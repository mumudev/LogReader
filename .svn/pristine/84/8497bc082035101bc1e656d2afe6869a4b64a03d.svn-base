package ALogReader;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;
import ch.ethz.ssh2.StreamGobbler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedReader;

public abstract class LogAppender
  extends Thread
{
  protected PipedReader reader;
  protected BufferedReader br;
  
  public LogAppender(String hostname, String username, String password, String execLine)
    throws IOException
  {
    try 
    {
      Connection conn = new Connection(hostname);
      conn.connect();
      boolean isAuthenticated = conn.authenticateWithPassword(username, password);
      if (!isAuthenticated) {
        throw new IOException("Authentication failed.");
      }
      Session sess = conn.openSession();
      sess.execCommand(execLine);
      InputStream stdout = new StreamGobbler(sess.getStdout());
      this.br = new BufferedReader(new InputStreamReader(stdout));
    }
    catch (IOException e)
    {
      e.printStackTrace(System.err);
      System.exit(2);
    }
  }
}
