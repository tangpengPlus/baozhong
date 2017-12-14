package com.bz.framework.util.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.ImageIcon;


/**
 * 图片工具类，图片裁剪， 图片水印，文字水印，缩放，补白等
 */
public class ImageUtils {

	public static final int POSITION_CENTER=0;
	public static final int POSITION_TOP_LEFT=1;
	public static final int POSITION_TOP_RIGHT=2;
	public static final int POSITION_BOTTOM_LEFT=3;
	public static final int POSITION_BOTTOM_RIGHT=4;
    
    private ImageUtils(){}
    
    /**
	 * 居中剪切图片
	 * 
	 * @param srcFile
	 *            原始图片
	 * @param w
	 *            剪切宽度（宽、高小于等于0时，为原始宽高）
	 * @param h
	 *            剪切高度（宽、高小于等于0时，为原始宽高）
	 * @throws IOException
	 */
	public static BufferedImage cutCenterImage(File srcFile,int w, int h) throws IOException {
		String fileName = srcFile.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName(suffix);
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(srcFile);
		
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		int imageIndex = 0;
		int width = reader.getWidth(imageIndex) - w;
		int height = reader.getHeight(imageIndex) - h;
		if (width < 1) {
			width = 0;
		}else{
			width = width/2;
		}
		if (height < 1) {
			height = 0;
		}else{
			height=height/2;
		}
		if(w<1){
			w= reader.getWidth(imageIndex);
			width=0;
		}
		if(h<1){
			h=reader.getHeight(imageIndex);
			height=0;
		}		
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(width, height, w, h);
		param.setSourceRegion(rect);
		BufferedImage pressImage = reader.read(0, param);
		
		return pressImage;
	}

	/**
	 * 图片裁剪二分之一
	 * @param srcFile 目标图片
	 * @return
	 * @throws IOException
	 */
	public static BufferedImage cutHalfImage(File srcFile) throws IOException {
		String fileName=srcFile.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		Iterator<ImageReader> iterator = ImageIO
				.getImageReadersByFormatName(suffix);
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(srcFile);
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		int imageIndex = 0;
		int width = reader.getWidth(imageIndex) / 2;
		int height = reader.getHeight(imageIndex) / 2;
		Rectangle rect = new Rectangle(width / 2, height / 2, width, height);
		param.setSourceRegion(rect);
		BufferedImage pressImage = reader.read(0, param);
		return pressImage;
	}

	/**
	 * 图片裁剪通用接口
	 * @param srcfile 目标图片
	 * @param x		剪切点 x
	 * @param y		剪切点 y
	 * @param w		剪切宽度
	 * @param h		剪切高度
	 * @return
	 * @throws IOException
	 */
	 
	public static BufferedImage cutImage(File srcfile,int x,int y, int w, int h) throws IOException {
		String fileName=srcfile.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		Iterator<ImageReader> iterator = ImageIO
				.getImageReadersByFormatName(suffix);
		ImageReader reader = (ImageReader) iterator.next();
		InputStream in = new FileInputStream(srcfile);		
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(x, y, w, h);
		param.setSourceRegion(rect);
		BufferedImage pressImage = reader.read(0, param);		
		return pressImage;
	}
    
    /**
     * 添加图片水印
     * @param targetImg 目标图片BufferedImage
     * @param waterImg  水印图片BufferedImage
     * @param position	水印位置
     * @param x 偏移量x
     * @param y 偏移量y
     * @param alpha 透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
     * @return 水印合成后的图像 BufferedImage
     */
    public final static BufferedImage pressImage(BufferedImage targetImg, BufferedImage waterImg,int position,int x,int y,float alpha) {
			int	width = targetImg.getWidth();
			int	height = targetImg.getHeight();
			Graphics2D	g = targetImg.createGraphics();			
			int waterWidth = waterImg.getWidth();
			int waterHeight = waterImg.getHeight();
			g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			int xy[] = getPositionXY(position, width, height, waterWidth, waterHeight);
			g.drawImage(waterImg, xy[0]+x, xy[1]+y, waterWidth, waterHeight, null); // 水印文件结束
			g.dispose();
			return targetImg;
    }
    

    /**
     * 添加文字水印
     * @param targetImg 目标图片BufferedImage
     * @param pressText 水印文字， 如：中国证券网
     * @param fontName  字体名称，    如：宋体
     * @param fontStyle 字体样式，如：粗体和斜体(Font.BOLD|Font.ITALIC)
     * @param fontSize  字体大小，单位为像素
     * @param color 	字体颜色
     * @param x 		偏移量
     * @param y 		偏移量
     * @param alpha 	透明度(0.0 -- 1.0, 0.0为完全透明，1.0为完全不透明)
     * @return 水印合成后的图像 BufferedImage
     */
    public static BufferedImage pressText(BufferedImage targetImg, String pressText, String fontName, int fontStyle, int fontSize, Color color,int position,int x, int y, float alpha) {
        	int	width = targetImg.getWidth();
			int	height = targetImg.getHeight();
			Graphics2D	g = targetImg.createGraphics();	
            g.setFont(new Font(fontName, fontStyle, fontSize));
            g.setColor(color);
            g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));          
            int waterWidth = fontSize * getLength(pressText);
            int waterHeight = fontSize;
            if(g.getFont().isBold()){
            	waterWidth=(fontSize+3) * getLength(pressText);
            }
            int xy[] = getPositionXY(position, width, height, waterWidth, waterHeight);
            g.drawString(pressText, xy[0]+x,xy[1]+waterHeight+y-10);
            g.dispose();
            return targetImg;
    }
    /**
     * 图片缩放
     * @param filePath 图片路径
     * @param dest 绽放图片路径
     * @param height 高度
     * @param width 宽度
     * @param bb 比例不对时是否需要补白
     */
    public static BufferedImage resize(File srcFile, int width,int height, boolean bb) {
        try {
            double ratio = 0; //缩放比例  
            BufferedImage bi = ImageIO.read(srcFile);   
            Image itemp = bi.getScaledInstance(width, height, BufferedImage.SCALE_SMOOTH);   
            //计算比例   
            if (bi.getHeight() > bi.getWidth()) {   
                ratio = (new Integer(height)).doubleValue() / bi.getHeight();   
            } else {   
                ratio = (new Integer(width)).doubleValue() / bi.getWidth();   
            }		
            AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(ratio, ratio), null);   
            itemp = op.filter(bi, null);   
            if (bb) {   
                BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
                Graphics2D g = image.createGraphics();   
                g.setColor(Color.white);   
                g.fillRect(0, 0, width, height);   
                if (width == itemp.getWidth(null)){   
                    g.drawImage(itemp, 0, (height - itemp.getHeight(null)) / 2, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                }else{ 
                    g.drawImage(itemp, (width - itemp.getWidth(null)) / 2, 0, itemp.getWidth(null), itemp.getHeight(null), Color.white, null);   
                    g.dispose();
                }
                itemp = image;   
            }
    		return (BufferedImage) itemp;
           
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
    }
    
    /**
     * 图片等比缩放
     * @param originalFile	原始图片
     * @param newWidth		新宽度
     * @param softenFactor	软化系数，范围0-1（0为不软化）
     * @return 返回绽放后的图片BufferedImage
     * @throws IOException
     */
	public static BufferedImage resize(File originalFile,int newWidth,float softenFactor) throws IOException {
		
		ImageIcon ii = new ImageIcon(originalFile.getCanonicalPath());
		Image i = ii.getImage();
		Image resizedImage = null;
		int iWidth = i.getWidth(null);
		int iHeight = i.getHeight(null);

		if (iWidth > iHeight) {
			resizedImage = i.getScaledInstance(newWidth, (newWidth * iHeight)
					/ iWidth, Image.SCALE_SMOOTH);
		} else {
			resizedImage = i.getScaledInstance((newWidth * iWidth) / iHeight,
					newWidth, Image.SCALE_SMOOTH);
		}
		// This code ensures that all the pixels in the image are loaded.
		Image temp = new ImageIcon(resizedImage).getImage();
		// Create the buffered image.
		BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null),
				temp.getHeight(null), BufferedImage.TYPE_INT_RGB);
		// Copy image to buffered image.
		Graphics g = bufferedImage.createGraphics();
		// Clear background and paint the image.
		g.setColor(Color.white);
		g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
		g.drawImage(temp, 0, 0, null);
		g.dispose();		
		// Soften.
		if(softenFactor>0){
			float[] softenArray = { 0, softenFactor, 0, softenFactor,
					1 - (softenFactor * 4), softenFactor, 0, softenFactor, 0 };
			Kernel kernel = new Kernel(3, 3, softenArray);
			ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
			bufferedImage = cOp.filter(bufferedImage, null);
		}
		return bufferedImage;
	} 
    
    /**
     * 获取字符长度，一个汉字作为 1 个字符, 一个英文字母作为 0.5 个字符
     * @param text
     * @return 字符长度，如：text="中国",返回 2；text="test",返回 2；text="中国ABC",返回 4.
     */
    private static int getLength(String text) {
        int textLength = text.length();
        int length = textLength;
        for (int i = 0; i < textLength; i++) {
            if (String.valueOf(text.charAt(i)).getBytes().length > 1) {
                length++;
            }
        }
        return (length % 2 == 0) ? length / 2 : length / 2 + 1;
    }
    /**
     * 获取水印添加点
     * @param position 	水印位置
     * @param width		图像宽度
     * @param height	图像高度
     * @param waterWidth	水印图像宽度
     * @param waterHeight	水印图像高度
     * @return 返回 水印添加起始点xy[];x=xy[0];y=xy[1] 
     */
    private static int[] getPositionXY(int position,int width,int height,int waterWidth,int waterHeight){
    	int[] xy= new int[2] ;
    	if(position==POSITION_TOP_LEFT){
    		xy[0]=0;
    		xy[1]=0;
    	}else if(position==POSITION_TOP_RIGHT){
    		xy[0]=width-waterWidth;
    		xy[1]=0;
    	}else if(position==POSITION_BOTTOM_LEFT){
    		xy[0]=0;
    		xy[1]=height-waterHeight;
    	}else if(position==POSITION_BOTTOM_RIGHT){
    		xy[0]=width-waterWidth;
    		xy[1]=height-waterHeight;
    	}else if(position==POSITION_CENTER){
    		xy[0]=(width-waterWidth)/2;
    		xy[1]=(height-waterHeight)/2;
    	}    	
    	return xy;
    	
    }
}
