
package ch.ethz.ssh2.log;

/**
 * Logger - a very simple logger, mainly used during development.
 * Is not based on log4j (to reduce external dependencies).
 * However, if needed, something like log4j could easily be
 * hooked in.
 * 
 * @author Christian Plattner, plattner@inf.ethz.ch
 * @version $Id: Logger.java,v 1.8 2006/10/06 12:55:40 cplattne Exp $
 */

public class Logger
{
	private static final boolean enabled = false;
	public final static Logger getLogger(Class<?> x)
	{
		return new Logger(x);
	}

	public Logger(Class<?> x)
	{
		x.getName();
	}

	public final boolean isEnabled()
	{
		return enabled;
	}

	public final void log(int level, String message)
	{
	}
}
