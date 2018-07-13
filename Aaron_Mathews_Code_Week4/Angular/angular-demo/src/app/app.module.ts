import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CoursesComponent } from './courses.component';
import { CourseComponent } from './course/course.component';
import { StructuralDirectivesComponent } from './structural-directives/structural-directives.component';

@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    CourseComponent,
    StructuralDirectivesComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
