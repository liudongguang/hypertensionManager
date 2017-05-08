package com.ldg.api.util;

import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorConvertOp;
import java.io.*;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by LiuDongguang on 2017/5/8.
 */
public class ImgeUtils {



    /**
     * 使用BufferedImage获取图片尺寸
     *
     * @param src
     *            源图片路径
     */
    public void getImageSizeByBufferedImage(String src) {
        long beginTime = new Date().getTime();
        File file = new File(src);
        FileInputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        }
        BufferedImage sourceImg = null;
        try {
            sourceImg = javax.imageio.ImageIO.read(is);
            System.out.println("width:" + sourceImg.getWidth());
            System.out.println("height:" + sourceImg.getHeight());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        long endTime = new Date().getTime();
        System.out.println("使用[BufferedImage]获取图片尺寸耗时：[" + (endTime - beginTime)+"]ms");
    }




    /***
     * 剪裁图片
     * @param src
     * @param dest
     * @param x  起点横坐标
     * @param y  纵坐标
     * @param w  长
     * @param h  高
     * @throws IOException
     * @date   2016-3-30下午12:19:10
     */
    public static boolean cutImage(String src,String dest,int x,int y,int w,int h) {
        try{
            Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = (ImageReader)iterator.next();
            InputStream in=new FileInputStream(src);
            ImageInputStream iis = ImageIO.createImageInputStream(in);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            x=(x>0?x:0);
            y=(y>0?y:0);
            Rectangle rect = new Rectangle(x, y, w,h);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0,param);
            ImageIO.write(bi, "jpg", new File(dest));
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean cutImage(InputStream srcINS,String dest,int x,int y,int w,int h) {
        try{
            Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = (ImageReader)iterator.next();
            ImageInputStream iis = ImageIO.createImageInputStream(srcINS);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            x=(x>0?x:0);
            y=(y>0?y:0);
            Rectangle rect = new Rectangle(x, y, w,h);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0,param);
            ImageIO.write(bi, "jpg", new File(dest));
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    public static boolean cutImage(MultipartFile avatar_file, String dest, int x, int y, int w, int h) {
        try{
            Iterator iterator = ImageIO.getImageReadersByMIMEType(avatar_file.getContentType());
            ImageReader reader = (ImageReader)iterator.next();
            ImageInputStream iis = ImageIO.createImageInputStream(avatar_file.getInputStream());
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            x=(x>0?x:0);
            y=(y>0?y:0);
            Rectangle rect = new Rectangle(x, y, w,h);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0,param);
            if("image/png".equals(avatar_file.getContentType())){
                ImageIO.write(bi, "png", new File(dest));
            }else{
                ImageIO.write(bi, "jpg", new File(dest));
            }


            return true;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }
    /***
     * 图片旋转指定角度
     * @param bufferedimage 图像
     * @param degree      角度
     * @return
     * @date   2016-3-30下午3:10:27
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
                                            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        //     graphics2d.setBackground(Color.white);
        graphics2d.setPaint(Color.WHITE);
        graphics2d.fillRect(0, 0, w, h);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0,Color.WHITE, null);
        graphics2d.dispose();
        return img;
    }
    public static boolean rotateImage(String srcImageFile, String result,
                                      int degree){
        try{
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
            BufferedImage tag= rotateImage(src, degree);

            ImageIO.write(tag, "JPEG", new File(result));

            return true;
        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }

    public static BufferedImage Rotate(Image src, int angel) {
        int src_width = src.getWidth(null);
        int src_height = src.getHeight(null);
        //  angel=angel>0?angel:(360-angel);
        // calculate the new image size
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(
                src_width, src_height)), angel);

        BufferedImage res = null;
        res = new BufferedImage(rect_des.width, rect_des.height,
                BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = res.createGraphics();
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, rect_des.width,  rect_des.height);
        // transform
        g2.translate((rect_des.width - src_width) / 2,
                (rect_des.height - src_height) / 2);
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);

        g2.drawImage(src, null, null);
        return res;
    }

    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {
        // if angel is greater than 90 degree, we need to do some conversion
        if (angel >= 90) {
            if(angel / 90 % 2 == 1){
                int temp = src.height;
                src.height = src.width;
                src.width = temp;
            }
            angel = angel % 90;
        }

        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;
        double angel_dalta_width = Math.atan((double) src.height / src.width);
        double angel_dalta_height = Math.atan((double) src.width / src.height);

        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_width));
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha
                - angel_dalta_height));
        int des_width = src.width + len_dalta_width * 2;
        int des_height = src.height + len_dalta_height * 2;
        return new java.awt.Rectangle(new Dimension(des_width, des_height));
    }

    public static boolean Rotate(String srcImageFile, String result,
                                 int degree){
        try{
            degree=degree>0?degree:(360-degree);
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            BufferedImage tag = Rotate(src, degree);
            ImageIO.write(tag, "JPEG", new File(result));
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return false;
        }
    }


    public static boolean cutAndRotateImage(String srcImageFile,String dest,int x,int y,int w,int h,int degree){
        try{
            BufferedImage src = ImageIO.read(new File(srcImageFile)); // 读入文件
            BufferedImage tag= Rotate(src, degree);
            Iterator iterator = ImageIO.getImageReadersByFormatName("jpg");
            ImageReader reader = (ImageReader)iterator.next();
            //     InputStream in=new FileInputStream(tag);
            ByteArrayOutputStream bs = new ByteArrayOutputStream();
            ImageOutputStream ios = ImageIO.createImageOutputStream(bs);
            ImageIO.write(tag, "jpg", ios);
            InputStream in=new ByteArrayInputStream(bs.toByteArray());
            ImageInputStream iis=ImageIO.createImageInputStream(in);
            reader.setInput(iis, true);
            ImageReadParam param = reader.getDefaultReadParam();
            x=(x>0?x:0);
            y=(y>0?y:0);
            Rectangle rect = new Rectangle(x, y, w,h);
            param.setSourceRegion(rect);
            BufferedImage bi = reader.read(0,param);
            ImageIO.write(bi, "jpg", new File(dest));
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            return false;
        }
    }


    /***
     * 转换图像格式
     * @param srcImageFile 原图像地址
     * @param formatName   转换类型
     * @param destImageFile 转换后的地址
     * @return
     * @author roychenyi
     * @date   2016-3-30下午2:49:15
     */
    public  static boolean convert(String srcImageFile, String formatName, String destImageFile) {
        try {
            File f = new File(srcImageFile);
            f.canRead();
            f.canWrite();
            BufferedImage src = ImageIO.read(f);
            ImageIO.write(src, formatName, new File(destImageFile));
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 彩色转为黑白
     * @param srcImageFile 源图像地址
     * @param destImageFile 目标图像地址
     */
    public final static void gray(String srcImageFile, String destImageFile) {
        try {
            BufferedImage src = ImageIO.read(new File(srcImageFile));
            ColorSpace cs = ColorSpace.getInstance(ColorSpace.CS_GRAY);
            ColorConvertOp op = new ColorConvertOp(cs, null);
            src = op.filter(src, null);
            ImageIO.write(src, "jpg", new File(destImageFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /**
     * 计算text的长度（一个中文算两个字符）
     * @param text
     * @return
     */
    public  static int getLength(String text) {
        int length = 0;
        for (int i = 0; i < text.length(); i++) {
            if (new String(text.charAt(i) + "").getBytes().length > 1) {
                length += 2;
            } else {
                length += 1;
            }
        }
        return length / 2;
    }

}
