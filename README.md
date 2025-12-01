# Portfolio Project - HexColor Component

A Java component for managing and manipulating hexadecimal color codes, built following the OSU CSE software sequence discipline. This component provides an API for working with hex colors, including color manipulation, accessibility checking, and theme generation.

## Overview

The HexColor component provides an interface for working with hexadecimal color codes in the format #RRGGBB. It includes functionality for:

Color Manipulation: Lighten and darken colors by specified factors
Color Analysis: Calculate luminance and generate complementary colors
RGB Conversion: Convert between hex codes and RGB integer values
Validation: Verify hex color code format compliance
Accessibility: Support for WCAG contrast ratio calculations

### Features

Core Functionality:

Get and set hex color values
Extract individual RGB components as hex strings
Set colors using RGB integer values (0-255)
Validate hex color code format
Compare colors for equality

Color Operations:

Lighten: Move colors toward white by a specified factor (0.0-1.0)
Darken: Move colors toward black by a specified factor (0.0-1.0)
Complement: Generate the complementary color (opposite on the color wheel)
Luminance: Calculate the perceived brightness of a color

### Getting Started

Prerequisites:

- Java JDK 11 or higher
- VSCode with Java extensions recommended
- JUnit 4 for testing

Installation:

- git clone <https://github.com/sayoku/component-sw-sequence.git>
- cd hexcolor-component
- Add required libraries: components.jar placed in the lib/ folder — discussed further below.

When you open VSCode with this project, you should get a notification in the bottom right corner that there are some recommended extensions to install. Click install all. If you ignored this message or it never came up, feel free to press CTRL+SHIFT+P and type "Show Recommended Extensions". Install all of the extensions listed.

### Add Key Libraries to Project

As you are probably all aware at this point, you need the components jar to get
anything running. My advice is to [download it from here][components-jar]. Then,
drop it into the `lib` folder in the project. Git automatically ignores anything
you put here by default, so don't worry about committing it to version control.

Similarly, you will need the testing APIs (e.g., JUnit). Perhaps the easiest way
to include them in your project is to click the beaker symbol in the left
sidebar; it's right below the extensions button which looks like four squares.
If you do not see this button, try creating a Java file in `src`. From there,
you can click "Enable Java Tests" and then click "JUnit" from the
dropdown. That's it! You should now see the two JUnit libraries in the lib
folder.

[components-jar]: https://cse22x1.engineering.osu.edu/common/components.jar
