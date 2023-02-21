package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image(description, dimensions);
        Blog blog = blogRepository2.findById(blogId).get();
        image.setBlog(blog);
        List<Image> imageList = blog.getImageList();
        imageList.add(image);
        blog.setImageList(imageList);
        blogRepository2.save(blog);
        return image;
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Image image = imageRepository2.findById(id).get();
        String dimensions = image.getDimensions();
        String[] size = dimensions.split("X");
        int length = Integer.valueOf(size[0]);
        int breadth = Integer.valueOf(size[1]);
        String[] ScreenSize = screenDimensions.split("X");
        int screenLength = Integer.valueOf(ScreenSize[0]);
        int screenBreadth = Integer.valueOf(ScreenSize[1]);
        return (screenLength/length)*(screenBreadth/breadth);
    }
}
