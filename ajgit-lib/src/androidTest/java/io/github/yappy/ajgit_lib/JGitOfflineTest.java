package io.github.yappy.ajgit_lib;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.util.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class JGitOfflineTest {
    @Test
    public void gitInit() throws Exception {
        Context appContext = InstrumentationRegistry.getTargetContext();

        File dir = new File(appContext.getFilesDir(), "gitInit.git");
        FileUtils.delete(dir, FileUtils.RECURSIVE | FileUtils.SKIP_MISSING);

        Git.init()
                .setDirectory(dir)
                .call();

        File gitDir = new File(dir, ".git");
        assertTrue(gitDir.isDirectory());
        assertTrue(new File(gitDir, "HEAD").isFile());
    }
}
