import { Component } from '@angular/core';

@Component({ // This is called a Decorator. Similar to a Spring Annotation
  selector: 'app-root', // this is the name of the custom tag
  templateUrl: './app.component.html', // <app-root> is replaced by this HTML content
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'my-first-angular-project'; // title is referred to in app.component.html in double curly braces
}
