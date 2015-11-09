Rodin Multi-Simulation
======================
[![Build Status](https://travis-ci.org/snursmumrik/multisim.svg?branch=master)](https://travis-ci.org/snursmumrik/multisim)

Multi-simulation environment for the [Rodin](http://sourceforge.net/projects/rodin-b-sharp/) platform based on the [FMI 1.0](https://www.fmi-standard.org) standard.

Enables graphical composition and co-simulation of Event-B machines and imported FMI units (FMUs).

Installation
------------

Currently can only be run from source, i.e. an Eclipse development environment workspace. First, make sure that you have the following prerequisites installed:
* [Oracle JDK 7 or above](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Apache Maven](https://maven.apache.org)

To set up the development environment follow these steps:

1. Download the latest version of [Eclipse](https://eclipse.org/downloads/), preferrably the build for Java and DSL developers.
2. Clone this repository and import it into a new workspace of your Eclipse installation.
3. The initial build should produce a lot of errors. That's normal. At this point Eclipse is pointing to a default target platform. To fix that go to *Preferences > Plug-in Development > Target Platform* and select *rodin-3.2* target as the active target (if not there, go to your workspace, find the project *ac.soton.multisim.target*, open the *.target* file and click *Set as Target Platform* in the upper right corner). Eclipse will take a while to resolve the target, as it dowloads all the dependencies from the corresponding update sites, hence it is important to have the internet connection at this point!
4. When the target is set there may be remaining errors due to the unresolved Tycho Maven tasks. Those can be fixed by either
 - Opening a *.pom* file of the *ac.soton.multisim.target* project, finding the error and selecting *Discover m2e connectors* from the quick fix popup hint.
 - Manually installing Tycho m2e connectors by going to *Help > Install New Software...* and intalling the Tycho Configurator from the (http://repo1.maven.org/maven2/.m2e/connectors/m2eclipse-tycho/0.9.0/N/LATEST/) update site.
5. To build the workspace use Maven by tight-clicking on the *ac.soton.multisim.parent* project and selecting *Run As > Maven build*. As the goals you can enter any Maven goals, e.g. *clean verify*.

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
If you notice a bug or have a good idea on improvement, please add it to the [Issues page](https://github.com/snursmumrik/multisim/issues).
