# [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

Implementing a Java program according to a given class diagram written in UML

## About

### What is [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

Simple aircraft logistics simulation program, based on the provided UML class diagram. [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf) takes a [Scenario File](https://github.com/ziadhorat/Avaj-launcher/blob/master/src/scenario.txt) which lists aircraft/s and their starting coordinates along with the amount of times to run the simulation. During each simulation, every aircraft react to the Towers weather updates relative to each aircraft by changing coordinates with specified step and logging a message to the [Simulation File](https://github.com/ziadhorat/Avaj-launcher/blob/master/src/simulation.txt). If the height of an aircraft reaches 0, it lands and unregisters from the Tower, terminating it's logged messages.

![](documentation/avaj_uml.jpg)

### Things I've learnt building [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

- The basics of Java, and Java development
- Understanding and implementing UML class diagrams
- Implementing OOP designs
- And more

## Usage

Compile and run with the script **[src/run.sh](https://github.com/ziadhorat/Avaj-launcher/blob/master/src/run.sh)**. The script takes the path to the scenario file as a parameter, if not specified it will default to [src/scenario.txt](https://github.com/ziadhorat/Avaj-launcher/blob/master/src/scenario.txt).

[scenario.txt](https://github.com/ziadhorat/Avaj-launcher/blob/master/src/scenario.txt) explained:

```
25
Baloon B1 2 3 20
JetPlane J1 23 44 32
```

```
Number of simulations to run
AircraftType CallSign Longitude Latitude Height
AircraftType CallSign Longitude Latitude Height
```
