/*
    Introduction to TypeScript
    Section 4: Access Modifiers & Fields vs. Properties
*/

/*
    Continuing on with our previous example of a Point class (renamed to Coordinate in
    order to avoid duplicate naming compilation errors), we will explore the other OOP
    features of TS. Specifically this demo will focus on the use of access modifiers.

    What if in our program, we want to restrict ourselves from working directly with an
    object's fields. To do this we need to use access modifiers:

                * public
                * protected
                * private
    
    Using access modifiers to restrict direct access to an object's fields makes objects 
    more predictable and reduces the chances of bugs. If no access modifier is given,
    it is assumed to be 'public' by default.
*/
class Coordinate {
    //private x: number;
    //private y: number;
    
    /*
        Access modifiers can be included in the constructor's to declare class fields, as 
        well as allowing us to remove the redundant assignments from before.

        The fields declared here have been prefixed with an underscore to avoid naming
        collisions with the getter and setter properties.
    */
    constructor(private _x?: number, private _y?: number) {
        /* 
            The TS compiler declares fields 'x' and 'y', and when the constructor is called
            with these parameters it goes ahead and initializes the fields automatically.
        */
    }

    /* 
        The 'public' keyword is not required, and it is recommended to omit it in most
        cases, as it makes the code noisy and cluttered.
    */
    public drawPoint = () => {
        console.log('x: ' + this._x + ', y: ' + this._y);
    }

    /*
        Since our fields are private, we cannot access them outside of our class. However,
        what if we want to be able to reassign the values of 'x' and 'y' after we create 
        a Coordinate object? We need to create specialized functions known as 'getters' and
        'setters' to allow us the ability to access and mutate these fields.
    */
    getX() {
        return this._x;
    }

    setX(value: number) {
        if (value < 0) {
            throw new Error('Value cannot be less than zero!');
        } else {
            this._x = value;
        }
    }

    /*
        Alternatively, in TS we can use properties to access and mutate our private fields.
        The keywords 'get' and 'set' are used as if they were fields (notice the icon changes
        when Y is invoked).

        Notice the naming convention used. This was done because if we used a lowercase 'y',
        then we would get a naming collision with the field declared within the constructor.

        Another way of avoid naming collisions and still using proper naming convention for
        our methods (Camel casing) is to prefix the fields declared within the constructor
        with an underscore (_).
    */
    get y() {
        return this._y;
    }

    set y(value: number) {
        if (value < 0) {
            throw new Error('Value cannot be less than zero!');
        } else {
            this._y = value;
        }
    }

}

let myCoordinate = new Coordinate(1, 2);

// compilation error! x is private and not visible outside of the class
//myCoordinate.x = 4;

myCoordinate.getX();
console.log('myCoordinate.y: ' + myCoordinate.y);
myCoordinate.y = 3;
console.log('myCoordinate.y: ' + myCoordinate.y);