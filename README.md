# [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

Implementing a Java program according to a given class diagram written in [UML](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj_uml.jpg)

![](https://github.com/ziadhorat/Avaj-launcher/workflows/Test/badge.svg)

## About

### What is [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

Simple aircraft logistics simulation program, based on the provided UML class diagram. [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf) takes a [Scenario File](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/scenario.txt) which lists aircraft/s and their starting coordinates along with the amount of times to run the simulation. During each simulation, every aircraft react to the Towers weather updates relative to each aircraft by changing coordinates with specified step and logging a message to the [Simulation File](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/simulation.txt). If the height of an aircraft reaches 0, it lands and unregisters from the Tower, terminating it's logged messages.

![](documentation/avaj_uml.jpg)

### Things I've learnt building [Avaj-launcher](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.en.pdf)

- The basics of Java, and Java development
- Understanding and implementing UML class diagrams (Oberserver[Publisher-Subscriber]/Singleton/FactoryMethod)
- Implementing OOP designs
- And a whole lot more

The [Marking Sheet](https://github.com/ziadhorat/Avaj-launcher/blob/master/documentation/avaj-launcher.markingsheet.pdf) we are marked against.

## Usage

Compile and run with the script **[source/run.sh](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/run.sh)**. The script takes the path to the scenario file as a parameter, if not specified it will default to [source/scenario.txt](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/scenario.txt).

[scenario.txt](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/scenario.txt) explained:

```
25                      | Number of simulations to run
Baloon B1 2 3 20        | AircraftType CallSign Longitude Latitude Height
JetPlane J1 23 44 32    | AircraftType CallSign Longitude Latitude Height
```

If the program has run successfully, you will receive the following output:

```
We have run X simulations.
Results are logged to simulation.txt file.
```

The results will then be accessible in [source/simulation.txt](https://github.com/ziadhorat/Avaj-launcher/blob/master/source/simulation.txt)
