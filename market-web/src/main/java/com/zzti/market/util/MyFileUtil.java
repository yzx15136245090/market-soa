package com.zzti.market.util;

/**
 * @Title:
 * @Package: com.zzti.market.util
 * @ClassName: FileUtil
 * @Description:
 * @Author: zhixiang.yang
 * @CreateDate: 2018/4/11 15:50
 * @UpdateUser: zhixiang.yang
 * @UpdateDate: 2018/4/11 15:50
 * @UpdateRemark:
 * @Version: 1.0
 */
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
public class MyFileUtil {
        /**
         * 获得指定文件的byte数组
         * @param filePath 文件绝对路径
         * @return
         */
        public static byte[] getByte(String filePath){
            ByteArrayOutputStream bos=null;
            BufferedInputStream in=null;
            try{
                File file=new File(filePath);
                if(!file.exists()){
                    throw new FileNotFoundException("file not exists");
                }
                bos=new ByteArrayOutputStream((int)file.length());
                in=new BufferedInputStream(new FileInputStream(file));
                int buf_size=1024;
                byte[] buffer=new byte[buf_size];
                int len=0;
                while(-1 != (len=in.read(buffer,0,buf_size))){
                    bos.write(buffer,0,len);
                }
                return bos.toByteArray();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
                return null;
            }
            finally{
                try{
                    if(in!=null){
                        in.close();
                    }
                    if(bos!=null){
                        bos.close();
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        /**
         * 根据byte数组，生成文件
         * @param bfile 文件数组
         * @param filePath 文件存放路径
         * @param fileName 文件名称
         */
        public static void getFile(byte[] bfile,String filePath,String fileName){
            BufferedOutputStream bos=null;
            FileOutputStream fos=null;
            File file=null;
            try{
                File dir=new File(filePath);
                if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
                    dir.mkdirs();
                }
                file=new File(filePath+fileName);
                fos=new FileOutputStream(file);
                bos=new BufferedOutputStream(fos);
                bos.write(bfile);
            }
            catch(Exception e){
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            finally{
                try{
                    if(bos != null){
                        bos.close();
                    }
                    if(fos != null){
                        fos.close();
                    }
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        }
    }

