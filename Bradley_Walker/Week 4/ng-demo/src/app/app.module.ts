import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppComponent } from './app.component';
import { CoursesComponent } from './courses.component';
import { CourseComponent } from './course/course.component';
import { StructuralDirectivesComponent } from './structural-directives/structural-directives.component';
import { ClickerComponent } from './clicker/clicker.component';
import { HeroesComponent } from './heroes/heroes.component';
import { AttributeDirectivesComponent } from './attribute-directives/attribute-directives.component';
import { FormsModule } from '@angular/forms';
import { AuthorsComponent } from './authors/authors.component';
import { TitleCasePipe } from './title-case.pipe';

@NgModule({
  declarations: [
    AppComponent,
    CoursesComponent,
    CourseComponent,
    StructuralDirectivesComponent,
    ClickerComponent,
    HeroesComponent,
    AttributeDirectivesComponent,
    AuthorsComponent,
    TitleCasePipe
  ],
  imports: [
    BrowserModule,
    NgbModule.forRoot(),
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
