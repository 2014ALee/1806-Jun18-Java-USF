"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var like_component_1 = require("./like-component");
// Start off with a LikeComponent that has 10 likes and is already selected.
var component = new like_component_1.LikeComponent(10, true);
// Print the inital component fields to the console
console.log("likesCount: " + component.likesCount + ", isSelected: " + component.isSelected);
// The user clicks the LikeComponent
// This will decrement the number of likes and deselect the component
component.onClick();
console.log("EVENT: LikeComponent clicked");
// Print the updated component fields to the console
console.log("likesCount: " + component.likesCount + ", isSelected: " + component.isSelected);
