package mvp.model.presenter.bean.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Created by Administrator on 2016/9/7.
 */
public class ImageUtils {

    //质量压缩
    public Bitmap compressBitmap(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        int options = 100;
        while (baos.toByteArray().length / 1024 > 100) {
            baos.reset();     //清空内存流
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);
            options -= 10;
        }
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        Bitmap b = BitmapFactory.decodeStream(bais, null, null);
        return b;
    }


    //图片按比例大小压缩(根据图片路径,也可以根据bitmap）
    private Bitmap getImages(String srcPath, int width, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        Bitmap bitmap = BitmapFactory.decodeFile(srcPath, options);
        options.inJustDecodeBounds = false;
        int w = options.outWidth;
        int h = options.outHeight;
        int be = 1; //代表不缩放
        if (w > h && w > width) {
            be = (int) options.outWidth / width;
        } else if (w < h && h > height) {
            be = (int) options.outHeight / height;
        }
        if(be<=0){
            be = 1;
        }
        options.inSampleSize = be;
        bitmap = BitmapFactory.decodeFile(srcPath,options);
        bitmap = compressBitmap(bitmap);
        return bitmap;
    }
}
