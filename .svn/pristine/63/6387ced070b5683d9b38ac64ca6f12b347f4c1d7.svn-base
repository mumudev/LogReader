package ALogReader;

import java.io.IOException;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;

public class MyTextPane
  extends JTextPane
{
  private static final long serialVersionUID = 1L;
  StringBuffer temp = new StringBuffer();
  HTMLDocument hd;
  int tempnum = 0;
  
  public MyTextPane()
  {
    super.setContentType("text/html");
    super.setEditable(false);
    this.hd = new HTMLDocument();
    this.hd = ((HTMLDocument)super.getDocument());
  }
  
  public void addText(String str)
  {
    if (this.tempnum == 0)
    {
      try
      {
        this.hd.setInnerHTML(this.hd.getDefaultRootElement(), str);
      }
      catch (BadLocationException ex)
      {
        ex.printStackTrace();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
      this.tempnum += 1;
    }
    else
    {
      try
      {
        System.out.println(this.hd.getElement("logs"));
        this.hd.insertBeforeEnd(this.hd.getElement("logs"), str.replaceFirst("xx-small", ""));
        super.setCaretPosition(super.getDocument().getLength());
      }
      catch (BadLocationException ex)
      {
        ex.printStackTrace();
      }
      catch (IOException ex)
      {
        ex.printStackTrace();
      }
    }
  }
}
