package org.csystem.io.image;

import java.io.IOException;

public interface IImage {
    String getIdentity() throws IOException;
    int getSize() throws IOException;
    int getWidth() throws Exception;
    int getHeight() throws Exception;
    //...
}
