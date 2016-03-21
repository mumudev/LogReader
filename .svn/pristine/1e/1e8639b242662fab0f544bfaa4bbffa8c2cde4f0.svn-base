package ALogReader;

import java.io.IOException;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class TextAreaLogAppender
  extends LogAppender
{
  private MyTextPane textPane;
  private JScrollPane scroll;
  private String lines = "";
  
  public TextAreaLogAppender(MyTextPane textPane, JScrollPane scroll, String hostname, String username, String password, String execLine)
    throws IOException
  {
    super(hostname, username, password, execLine);
    this.textPane = textPane;
    this.scroll = scroll;
  }
  
  @SuppressWarnings("resource")
public void run()
  {
    Scanner scanner = new Scanner(this.br);
    SimpleAttributeSet attrset = new SimpleAttributeSet();
    StyleConstants.setFontSize(attrset, 12);
    while (scanner.hasNextLine()) {
      try
      {
        String line = this.br.readLine();
        setLogText(line);
        this.scroll.getVerticalScrollBar().setValue(
          this.scroll.getVerticalScrollBar().getMaximum());
      }
      catch (Exception localException) {}
    }
  }
  
  private void setLogText(String line)
  {
    if ((!line.contains("</td>")) && (!line.contains("</tr>")) && 
    	      (!line.contains("<td>")) && (!line.contains("<tr>")) && 
    	      (!line.contains("<html>")) && (!line.contains("</html>")) && 
    	      (!line.contains("body>")) && (!line.contains("</body>")) && 
      (!line.trim().isEmpty()))
    {
      line = line.concat("<br/>");
      System.out.println("输出line：|" + line + "|end");
    }
    this.lines = this.lines.concat(line);
    if (line.contains("</tr>"))
    {
      this.textPane.addText(this.lines);
      this.lines = "";
    }
  }
}
