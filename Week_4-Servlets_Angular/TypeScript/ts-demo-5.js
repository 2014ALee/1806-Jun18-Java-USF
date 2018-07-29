"use strict";
/*
    Introduction to TypeScript
    Section 5 - Modules
*/
exports.__esModule = true;
/*
    Continuing on with our examples from earlier demos, we will simplify our class a bit to
    facilitate our discussion regarding modules.

    In real applications, we rarely work with a single file but instead a collection of dozens
    or hundreds of other files. So, let's move our class declaration to another file called
    'Dot.ts'.

    Since the class is no longer a part of this file, we need to import it in order to be
    able to use it. We need to specify what class(es) we are importing and the relative
    path of the file. By including imports, TS views this file as it's own module.
*/
var dot_1 = require("./dot");
var myDot = new dot_1.Dot(1, 2);
myDot.draw();
