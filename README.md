**This readme file will contain some points which I came across while learning and can be marked as tips**

Tip 1:
Under class when any WebElement is used multiple times and across all the methods then that can be mentioned with class as static. Example:
class LearningSelenium {
@FindBy(id = "element_id") WebElement webElement;  //Now this webElement can be used on any methods across the class where this element is desired
.
.
.

}

