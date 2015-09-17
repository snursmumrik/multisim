package ac.soton.multisim.diagram.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;

public class MyBorderItemLocator extends BorderItemLocator {
	
	/** * Use to "middle overlap" the affixed child */
	private static final int halfSizeOfAfffixedChild = 0;
	private int sd;

	public MyBorderItemLocator(IFigure parentFigure) {
		super(parentFigure);
		setBorderItemOffset(new Dimension(halfSizeOfAfffixedChild,
				halfSizeOfAfffixedChild));
	}

	public MyBorderItemLocator(IFigure mainFigure, int preferredSide) {
		super(mainFigure, preferredSide);
		sd = preferredSide;
		setBorderItemOffset(new Dimension(halfSizeOfAfffixedChild,
				halfSizeOfAfffixedChild));
	}

	/**
	 * * Get an initial location based on the side. ( choose first sixth part of
	 * the side for SOUTH or call super) * * @param side * the preferred side of
	 * the parent figure on which to place this * border item as defined in
	 * {@link PositionConstants} * @return point
	 */
	protected Point getPreferredLocation(int side, IFigure borderItem) {
		{
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			int parentFigureHeight = bounds.height;
			int parentFigureX = bounds.x;
			int parentFigureY = bounds.y;
			int x = parentFigureX;
			int y = parentFigureY;
	
			Dimension borderItemSize = getSize(borderItem);
	
			if (sd == PositionConstants.SOUTH) {
				x += parentFigureWidth / 2 - borderItemSize.width/2 ;
				y = parentFigureY + parentFigureHeight - getBorderItemOffset().height;
				return new Point(x, y);
			}
			else if (sd == PositionConstants.EAST) {
				x += parentFigureWidth - getBorderItemOffset().width;
				y +=  borderItemSize.height/2; 
				return new Point(x, y);
			}
		}
		
		
		if (side == PositionConstants.SOUTH) {
			Rectangle bounds = getParentBorder();
			int parentFigureWidth = bounds.width;
			int parentFigureHeight = bounds.height;
			int parentFigureX = bounds.x;
			int parentFigureY = bounds.y;
			int x = parentFigureX;
			int y = parentFigureY; /*
									 * Play with this for modify the horizontal
									 * position on the activity Figure
									 */
			x += parentFigureWidth / 6;
			y = parentFigureY + parentFigureHeight
					- getBorderItemOffset().height;
			return new Point(x, y);
		} else {
			return super.getPreferredLocation(side, borderItem);
		}
	}
}