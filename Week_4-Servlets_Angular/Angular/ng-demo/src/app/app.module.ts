import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { CoursesComponent } from './courses.component';
import { CourseComponent } from './course/course.component';
import { StructuralDirectivesComponent } from './structural-directives/structural-directives.component';
import { AttributeDirectivesComponent } from './attribute-directives/attribute-directives.component';
import { AuthorsComponent } from './authors/authors.component';
import { TitleCasePipe } from './title-case.pipe';

@NgModule({
  // declarations = components, custom pipes, and custom directives
  declarations: [
    AppComponent,
    CoursesComponent,
    CourseComponent,
    StructuralDirectivesComponent,
    AttributeDirectivesComponent,
    AuthorsComponent,
    TitleCasePipe
  ],
  // imports = external modules
  imports: [
    BrowserModule,
    FormsModule
  ],
  // providers = services (component dependencies)
  providers: [],
  // bootstrap = root component of this module
  bootstrap: [AppComponent]
})
export class AppModule { }
