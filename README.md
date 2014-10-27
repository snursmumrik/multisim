Rodin Multi-Simulation
======================

Multi-simulation environment for the [Rodin](http://sourceforge.net/projects/rodin-b-sharp/) platform based on the [FMI 1.0](https://www.fmi-standard.org) standard.

Enables graphical composition and co-simulation of Event-B machines and imported FMUs.

Installation
------------
Currently can only be run from the source, i.e. an Eclipse workspace. To set up the development environment follow these steps:

1. Download the latest version of [Rodin](http://sourceforge.net/projects/rodin-b-sharp/) (3.0) and intstall [ProB 2.0](https://github.com/bendisposto/prob2) according to the instructions on the prob2 repository. Ensure that ProB is up and running. An easy way to do this is to open a Groovy console and load an Event-B machine via command `api.eventb_load("/home/pathToFile/example.bum")`.
2. In addition to ProB install the *GMF Tooling - Runtime Extensions* from the http://download.eclipse.org/modeling/gmp/gmf-tooling/updates/releases/ update site. This is required by any GMF-based plug-in for Rodin.
3. Clone this repository and import it into a new workspace of your Eclipse installation.
4. In Eclipse *Preferences > Plug-in Development > Target Platform* add a new target that has a *Directory* content pointed at the Rodin with ProB 2.0, installed in step 1. Set the new target to be the active target. If you have build errors try to clean the workspace and rebuild it. Some missing dependency errors may require you to additionally install the *EMF SDK*, *EMF Compare SDK* and *GMF Runtime SDK* into your target Rodin installation - all of which are available from the *Indigo* update site of the *Install New Software* wizard.

Usage
-----
* To run the plug-in simply run the code from Eclipse, which should start your Rodin target along with ProB.
* To create a co-simulation diagram right-click on a project of your choice and select *New > Multisim Diagram*. This will create a Multisim diagram file (.msd) in that project and open the diagram editor.
* To create an Event-B component from an existing Event-B machine just drag and drop the machine from the *Event-B Explorer* view onto the diagram canvas and follow the *Event-B Import Wizard*. Event-B components require you to specify:
  *  A step period in milliseconds - the rate at which an Event-B component will be synchronised with other components in terms of the global simulation time.
  *  At least one Wait event on which the synchronisation will occur.
  *  If the component has inputs, at least one Read event.
  *  Input and output ports.
  
  The configuration is saved in the Event-B machine and can be seen as a component under the machine root in Event-B Explorer. It then can be imported by dragging the component directly from the view to the canvas.
* To create an FMU component from an FMU file (.fmu) drag the file from either a file system or the *Navigator* view of Rodin onto the canvas.
* Components can be connected via input/output ports using *Connectors*. To create a connector simply hover the mouse over a port until a connection handle occurs, which then can be dragged to the destination port. An input port (light) can only be connected to a single output port (dark). Ports must also match in signal type (Real, Integer, Boolean or String).
* All imported components are automatically added into the diagram palette and can be instantiated from it.
* Simulation can be started by clicking on the *Simulate* icon and entering a simulation start time, stop time and step size, as well extra ProB arguments of required and whether an Event-B trace should be recorded. Automatic validation will be executed prior the simulation to verify that connected port types are compatible and all attributes of components are valid.
* To see the simulation results add some *Display* components to the diagram and link them to the output ports of components, whose signals you would like to observe. Ports can be added to a Display via a popup bar when hovering the mouse over it. Double-clicking on a Display component opens a plot window. Besides the plots all signal outputs are saved into a .csv file.

Bug Reports/Improvements
------------------------
If you notice a bug or have a good idea on improvement, please add it to the [open issues](https://github.com/snursmumrik/rms2/issues?state=open).
