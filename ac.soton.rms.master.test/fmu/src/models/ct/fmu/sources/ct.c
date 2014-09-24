/* ---------------------------------------------------------------------------*
 * Sample implementation of an FMU - increments an int counter every second.
 * (c) 2010 QTronic GmbH 
 * ---------------------------------------------------------------------------*/

// define class name and unique id
#define MODEL_IDENTIFIER ct
#define MODEL_GUID "{8c4e810f-3df3-4a00-8276-176fa3c9f009}"

// define model size
#define NUMBER_OF_REALS 0
#define NUMBER_OF_INTEGERS 2
#define NUMBER_OF_BOOLEANS 0
#define NUMBER_OF_STRINGS 0
#define NUMBER_OF_STATES 0
#define NUMBER_OF_EVENT_INDICATORS 0

// include fmu header files, typedefs and macros
#include "fmuTemplate.h"

// define all model variables and their value references
// conventions used here:
// - if x is a variable, then macro x_ is its variable reference
// - the vr of a variable is its index in array  r, i, b or s
// - if k is the vr of a real state, then k+1 is the vr of its derivative
#define u_ 0
#define y_ 1

// Linux: Functions in this file are declared to be static so
// that when the fmu_* method invokes one of these methods, then
// it gets the definition in the same shared library instead
// of getting the method with the same name in a previously
// loaded shared library.

// called by fmiInstantiateModel
// Set values for all variables that define a start value
// Settings used unless changed by fmiSetX before fmiInitialize
static void setStartValues(ModelInstance *comp) {
    comp->i[u_] = 0;
    comp->i[y_] = 0;
}

// called by fmiInitialize() after setting eventInfo to defaults
// Used to set the first time event, if any.
static void initialize(ModelInstance* comp, fmiEventInfo* eventInfo) {
    eventInfo->upcomingTimeEvent   = fmiTrue;
    eventInfo->nextEventTime       = 1 + comp->time;
}

// called by fmiEventUpdate() after setting eventInfo to defaults
// Used to set the next time event, if any.
static void eventUpdate(ModelInstance* comp, fmiEventInfo* eventInfo) {
    comp->i[u_] += 1;
    comp->i[y_] = comp->i[u_];
    eventInfo->upcomingTimeEvent   = fmiTrue;
    eventInfo->nextEventTime       = 1 + comp->time;
} 

// include code that implements the FMI based on the above definitions
#include "fmuTemplate.c"

