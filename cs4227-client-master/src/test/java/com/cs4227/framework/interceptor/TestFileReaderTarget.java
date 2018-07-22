package com.cs4227.framework.interceptor;

import com.cs4227.framework.filehandler.FileReaderTarget;
import com.cs4227.framework.filehandler.PostFileHandlerContext;
import com.cs4227.framework.filehandler.PreFileHandlerContext;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestFileReaderTarget {

    private static final String TEST_IMAGE_DIRECTORY = System.getProperty("user.dir")
            + "/src/test/resources/imageDefault.jpg";
    private static final String OPEN_SUCCESSFUL = "Success.";

    private FileReaderTarget target;

    @Before
    public void setup() {
        target = new FileReaderTarget();
    }

    @Test
    public void testReadImage() throws Exception {
        PreFileHandlerContextCreator contextCreator = new PreFileHandlerContextCreator();
        PreFileHandlerContext context = contextCreator.createPreFileHandlerContext(TEST_IMAGE_DIRECTORY);
        PostFileHandlerContext postRequestContext = target.execute(context);
        assertEquals(postRequestContext.getOutcomeContext().getStateMessage(), OPEN_SUCCESSFUL);
    }

}
