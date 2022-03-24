---
layout: page
title: User Guide
---
# McKitchen User Guide
McKitchen (My-CLI-Kitchen) is a desktop application that can quickly store, edit, and search for recipes by running a single command, ideal for the fast typists, home cooks, and students who want a simple way to store or search for simple recipes to cook.

## Table of Content
{:toc} (TO UPDATE)

---

## Quick start

1. Ensure you have Java `11` or above installed in your Computer by clicking [here](https://www.java.com/en/download/help/version_manual.html).
   1. If you do not have Java version >= `11` installed, refer to [this installation guide](https://docs.oracle.com/en/java/javase/11/install/overview-jdk-installation.html).

2. Download the latest `McKitchen.jar` from [here](https://github.com/AY2122S2-CS2103T-T17-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your McKitchen.

4. To run the application, if you're on:
   1. Windows: Double-click the file to start the app.
   2. MacOS/UNIX: Open the terminal in the _home folder_ (Step 3) and issue the following command: `java -jar McKitchen.jar`

The GUI similar to the below should appear in a few seconds <to update>. <br>
Note how the app contains some sample data.<br>
      ![Ui](images/Ui.png)

5. (TO UPDATE) Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some commands and what they do:

    * [**`add`**](#add-recipe): Adds a new recipe.
    * [**`delete`**](#delete-recipe): Deletes a recipe.
    * [**`find`**](#find-recipe): Displays a list of recipes with the specified keywords
    * [**`list`**](#list-recipe): Lists all the stored recipes.
    * [**`view`**](#view-recipe): Displays the full content of a recipe.
    * [**`clear`**](#clear-recipe): Clears all existing recipes in a recipe book.

6. Refer to the [Features](#features) below for details of each command.

---

## Features

### Add recipe
Add a recipe by specifying its name, ingredients, and steps to prepare the dish.<br>
Usage: `create recipe n/ <name of recipe> i/ <ingredients separated by commas> s/ <steps separated by commas>` <br>
Example:
- `create recipe n/ Aglio Olio i/ spaghetti 56 grams, garlic 3 cloves, bacon 3 slices, olive oil 110 ml, salt ?, pepper ? s/ Cook the spaghetti until al dante, Saute the chopped garlic, Toss spaghetti in the sauce, taste and season with salt and black pepper`
  - This creates a recipe for "Aglio Olio" with 56 grams of spaghetti, 3 cloves of garlic, 3 slices of bacon, 110 ml of olive oil and a non-fixed amount of salt, and pepper (to taste) with the steps of:
    1. Cook the spaghetti until al dante,
    2. Saute the chopped garlic,
    3. Toss the spaghetti in the sauce,
    4. Taste and season with salt and black pepper.

###### [return to table of content](#table-of-content)

### Delete recipe
Removes a stored recipe based on the number it is associated with in the `list` <br>
Usage: `delete <recipe number>` <br>
Example:
- delete 1
    - This would delete the first entry in the list of recipes.

###### [return to table of content](#table-of-content)

### Find recipe
Searches for a recipe based on the keywords (seperated by comma). <br>
Usage: `find <keyword> [, other keywords, seperated by comma]` <br>
Example: 
- find western, fish
  - This would display all the recipes that are "western", contains "fish", or both.

###### [return to table of content](#table-of-content)

### List recipe
Displays all the available recipes that has been stored locally <br>
Usage: `list`

###### [return to table of content](#table-of-content)

### View recipe
View the contents of an existing stored recipe based on recipe name or index. <br>
Usage: `view <recipe name>` <br>
Example:
- view Aglio Olio
    - This would display the full contents of the recipe matching the name "Aglio Olio" including its ingredients and steps to prepare the dish.
    
### Clear recipe
Clears the entire recipe book. A confirmation prompt would show up before the user could clear immediately. <br>
To clear the recipe book without the confirmation, users simply have to include the prefix `-f` after the `clear` 
command <br>

####Clear:
Usage: `clear` <br>

The program would then prompt the user to confirm. Type in `yes` to clear and `no` to cancel the clear request.

Example: 
- clear
    - This would generate a clear request that requires a confirmation. To confirm to clear the recipe book, type in 'yes',
    - else, type in 'no'.
  
####Forced Clear:
Usage: `clear <-f: Prefix for forced Clear>` <br>
Example:
- clear -f
    - This would clear the recipe book without having the need for any confirmation.
    
Usage: `view -x <recipe index>` <br>
Example:
- view -x 1
    - This would display the full contents of the first recipe in the list which includes its ingredients and steps to prepare the dish.

###### [return to table of content](#table-of-content)

### Store recipe
Store the recipe in a human-readable text file on the user's computer and is modifiable through a text editor if the user is familiar with the format (JSON). <br>
Usage: (Automatically updates text file upon each modifying (writing) operation).

###### [return to table of content](#table-of-content)

### Load recipe
Load existing recipes from the text file on the user's computer. Modifications to this file would be displayed accordingly as long as the format is followed. <br>
Usage: (Automatically loads the recipes upon launching the application).

###### [return to table of content](#table-of-content)

---

## FAQ
(To be filled)

###### [return to table of content](#table-of-content)

---

## Command Summary
(To be filled)

| Action               | Command format                                                                                          |
|----------------------|---------------------------------------------------------------------------------------------------------|
| add a new recipe     | `create recipe n/ <name of recipe> i/ <ingredients separated by commas> s/ <steps separated by commas>` |
| delete a recipe      | `delete <recipe number from list>`                                                                      |
| find a recipe        | `find <keyword> [, other keywords, seperated by comma]`                                                 |
| list a recipe        | `list`                                                                                                  |
| view specific recipe | `view <recipe number from list>`                                                                        |

###### [return to table of content](#table-of-content)

