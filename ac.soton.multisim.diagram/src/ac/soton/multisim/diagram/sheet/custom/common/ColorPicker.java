/*******************************************************************************
 * Copyright (c) 2012 Original authors and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Original authors and others - initial API and implementation
 ******************************************************************************/
package ac.soton.multisim.diagram.sheet.custom.common;


import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.ColorDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;

/**
 * A button that displays a solid block of color and allows the user to pick a color. The user can double click on the
 * button in order to change the selected color which also changes the background color of the button.
 *
 */
public class ColorPicker extends CLabel {

    protected static final RGB defaultRGB = new RGB(125,125,125);
	private Color selectedColor;
	private Image image;

    public ColorPicker(Composite parent, final Color originalColor) {
        super(parent, SWT.SHADOW_OUT);
        this.selectedColor = originalColor;
        setImage(getColorImage(originalColor));
        addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseDown(MouseEvent e) {
                        ColorDialog dialog = new ColorDialog(new Shell(Display.getCurrent(), SWT.SHELL_TRIM));
                        dialog.setRGB(selectedColor == null ? defaultRGB : selectedColor.getRGB());
                        RGB selected = dialog.open();
                        if (selected != null) {
                            update(selected);
                    		Event event = new Event();
							event.time = e.time;
							event.data = selected;
                    		notifyListeners(SWT.Modify, event);
                        }
                    }
                });
    }

    private Image getColorImage(Color color){
    	Display display = Display.getCurrent();
		image = new Image(display, new Rectangle(10, 10, 50, 20));
        GC gc = new GC(image);
        if (color != null) {
	        gc.setBackground(color);
	        gc.fillRectangle(image.getBounds());
        } else {
        	String string = "Auto";
			Point fsize = gc.textExtent(string);
			gc.drawText(string, (50-fsize.x)/2, (20-fsize.y)/2);
        }
        gc.setForeground(ColorConstants.gray);
        gc.drawRectangle(0, 0, 49, 19);
        gc.dispose();
        return image;
    }

    private void update(RGB selected) {
        this.selectedColor = selected != null ? new Color(getDisplay(), selected) : null;
        setImage(getColorImage(selectedColor));
    }

    /**
     * @return the Color most recently selected by the user. <em>Note that it is the responsibility of the client to
     *         dispose this resource</em>
     */
    public Color getSelectedColor() {
        return selectedColor;
    }

    /**
     * Set the current selected color that will be displayed by the picker. <em>Note that this class is not responsible
     * for destroying the given Color object. It does not take ownership. Instead it will create its own internal
     * copy of the given Color resource.</em>
     *
     * @param backgroundColor
     */
    public void setSelectedColor(Color backgroundColor) {
        update(backgroundColor != null ? backgroundColor.getRGB() : null);
    }

	@Override
    public void dispose() {
    	super.dispose();
    	image.dispose();
    }
    
    /**
     * Adds color modification listener.
     * 
     * @param listener
     */
    public void addModifyListener (ModifyListener listener) {
    	checkWidget();
    	if (listener == null) SWT.error (SWT.ERROR_NULL_ARGUMENT);
    	addListener(SWT.Modify, new SWTListener(listener));
    }
}