# Build the .fmu files for both co-simulation and model-exchange.
#
# The build_fmu script calls make with the appropriate makefile variables set.

# The architecture: linux32, linux64, darwin32, darwin64
ARCH = darwin64

# Either cs for co-simuluation or me for model exchange.
CSORME = cs
CS_INCLUDE = -DFMI_COSIMULATION -I../../include

# The suffix for shared libraries.
# dylib for Mac OS X, so for Linux
SHARED_LIBRARY_SUFFIX = dylib
#SHARED_LIBRARY_SUFFIX = so

# Empty for Mac OS X, -fPIC for Linux
PIC =

# Build the .fmu files for co-simulation
all:
	./build_fmu inc
	./build_fmu ct

# CBITSFLAGS is set to -m32 to build linux32 fmus

%.o: %.c
	echo `pwd`
	$(CC) -g -c $(CBITSFLAGS) $(PIC) -Wall $(CS_INCLUDE) $(CFLAGS) $< -o $@

%.so: %.o
	$(CC) $(CBITSFLAGS) -shared -Wl,-soname,$@ -o $@ $<

%.dylib: %.o
	echo `pwd`
	$(CC) -dynamiclib -o $@ $< -L. -Iinclude

%.fmu: %.$(SHARED_LIBRARY_SUFFIX)
	rm -rf fmu
	mkdir -p fmu/binaries/$(ARCH) fmu/sources fmu/documentation
	cp $< fmu/binaries/$(ARCH)
	-cp *.c *.h fmu/sources
	-cp *.html *.png fmu/documentation
	cat modelDescription.xml ../$(CSORME).xml > fmu/modelDescription.xml
	cp model.png fmu
	@if [ ! -d ../../../fmu ]; then \
		echo "mkdir -p ../../../fmu"; \
		mkdir -p ../../../fmu; \
	fi
	(cd fmu; zip -q -r ../../../../fmu/$@ *)

clean:
	(cd inc; make dirclean)

dirclean:
	rm -rf *.so *.dylib *.o *.fmu *~ fmu
