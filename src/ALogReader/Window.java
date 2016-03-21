package ALogReader;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Window
  extends JFrame
{
  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private MyTextPane textPane;
  private String hostname = "192.168.1.177";
  private String username = "ycl";
  private String password = "231";
  private String address  = "/home/ycl/tomcat/";
  private String execLine = address+"8080-tomcat8/logs/info.html";
  private String execLine1 = address+"8188-tomcat8/logs/info.html";
  private String execLine2 = address+"8288-tomcat8/logs/info.html";
  private String execLine3 = address+"8388-tomcat8/logs/info.html";
  private String lines = "<html><body><style type=\"text/css\">"
  		+ "</style></head><body bgcolor=\"#FFFFFF\" topmargin=\"6\" leftmargin=\"6\">"
  		+ "<table cellspacing=\"0\" id=\"logs\" "
  		+ "cellpadding=\"4\" border=\"1\" bordercolor=\"#224466\" width=\"100%\">"
  		+ "</table></body></html>";
  private JScrollPane scrollPane;
  private JPanel panel;
  private JTextField ssh_Username_txt;
  private JTextField ssh_Password_txt;
  private JTextField ssh_IP_txt;
  private JButton ShowBtn;
  private JLabel ssh_Username_Lab;
  private JLabel ssh_Password_Lab;
  private JLabel fileLocation_Lab;
  private JLabel ssh_IP_Lab;
  private JComboBox<String> fileLocation_txt;
  private TextAreaLogAppender tAppender;
  
  public static void main(String[] args)
  {
    EventQueue.invokeLater(new Runnable()
    {
      public void run()
      {
        try
        {
          Window frame = new Window();
          frame.setVisible(true);
        }
        catch (Exception e)
        {
          e.printStackTrace();
        }
      }
    });
  }
  
  @SuppressWarnings("deprecation")
public void initLog()
  {
    try
    {
      if (!this.ssh_IP_txt.getText().isEmpty()) {
        this.hostname = this.ssh_IP_txt.getText();
      }
      if (!this.ssh_Username_txt.getText().isEmpty()) {
        this.username = this.ssh_Username_txt.getText();
      }
      if (!this.ssh_Password_txt.getText().isEmpty()) {
        this.password = this.ssh_Password_txt.getText();
      }
      if (!((String)this.fileLocation_txt.getEditor().getItem()).isEmpty()) {
        this.execLine = ((String)this.fileLocation_txt.getEditor().getItem());
      }
      if (this.tAppender != null) {
          this.tAppender.stop();
      }
      this.tAppender = new TextAreaLogAppender(
        this.textPane, this.scrollPane, this.hostname, this.username, this.password, 
        "tail -f ".concat(this.execLine));
      this.textPane.setText(this.lines);
      this.tAppender.start();
    }
    catch (Exception e)
    {
      JOptionPane.showMessageDialog(this, e, "绑定日志输出组件错误", 0);
    }
  }
  
  private void init()
  {
    setDefaultCloseOperation(3);
    setBounds(0, 0, 1366, 768);
    this.contentPane = new JPanel();
    this.textPane = new MyTextPane();
    this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(this.contentPane);
    this.contentPane.setLayout(new BorderLayout(0, 0));
    this.scrollPane = new JScrollPane();
    this.contentPane.add(this.scrollPane, "Center");
    this.scrollPane.setViewportView(this.textPane);
    this.textPane.setContentType("text/html");
    
    this.panel = new JPanel();
    this.panel.setBorder(new LineBorder(Color.LIGHT_GRAY));
    this.scrollPane.setColumnHeaderView(this.panel);
    this.panel.setLayout(new BoxLayout(this.panel, 2));
    this.ssh_IP_Lab = new JLabel("ssh_IP");
    this.ssh_Username_Lab = new JLabel("ssh_Username");
    this.ssh_Password_Lab = new JLabel("ssh_Password");
    this.fileLocation_Lab = new JLabel("fileLocation");
    this.ssh_IP_txt = new JTextField(this.hostname);
    this.ssh_Username_txt = new JTextField(this.username);
    this.ssh_Password_txt = new JTextField(this.password);
    Vector<String> v = new Vector<String>();
    v.add(this.execLine);
    v.add(this.execLine1);
    v.add(this.execLine2);
    v.add(this.execLine3);
    this.fileLocation_txt = new JComboBox<String>(v);
    this.fileLocation_txt.setEditable(true);
    this.ShowBtn = new JButton("Show");
    this.ShowBtn.addActionListener(new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {
        Window.this.initLog();
        Window.this.textPane.addText(Window.this.lines);
      }
    });
    this.panel.add(this.ssh_IP_Lab);
    this.panel.add(this.ssh_IP_txt);
    this.panel.add(this.ssh_Username_Lab);
    this.panel.add(this.ssh_Username_txt);
    this.panel.add(this.ssh_Password_Lab);
    this.panel.add(this.ssh_Password_txt);
    this.panel.add(this.fileLocation_Lab);
    this.panel.add(this.fileLocation_txt);
    this.panel.add(this.ShowBtn);
    this.ssh_IP_txt.setColumns(1);
    this.ssh_Username_txt.setColumns(1);
    this.ssh_Password_txt.setColumns(1);
  }
  
  public Window()
  {
    init();
    
    setVisible(true);
  }
}
