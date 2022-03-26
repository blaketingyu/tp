package seedu.address.model;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.nio.file.Path;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.recipe.Recipe;

/**
 * Represents the in-memory model of the recipe book data.
 */
public class RecipeBookModelManager implements Model {
    //TODO: rename to "ModelManager" once we confirm that we don't need AB3 files
    private static final Logger logger = LogsCenter.getLogger(RecipeBookModelManager.class);

    private final RecipeBook recipeBook;
    private final RecipeBookUserPrefs userPrefs;
    private final FilteredList<Recipe> filteredRecipes;

    // ====== Constructors ======

    /**
     * Initializes a ModelManager with the given recipeBook and userPrefs
     */
    public RecipeBookModelManager(ReadOnlyRecipeBook recipeBook, ReadOnlyUserPrefs userPrefs) {
        requireAllNonNull(recipeBook, userPrefs);

        logger.fine(String.format("Initializing with recipe book: %s and user prefs %s", recipeBook, userPrefs));

        this.recipeBook = new RecipeBook(recipeBook);
        this.userPrefs = new RecipeBookUserPrefs(userPrefs);
        filteredRecipes = new FilteredList<>(this.recipeBook.getRecipeList());
    }

    /**
     * Initializes a ModelManager with a new recipeBook and userPrefs
     */
    public RecipeBookModelManager() {
        this(new RecipeBook(), new RecipeBookUserPrefs());
    }

    // ====== UserPrefs ======

    @Override
    public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
        requireNonNull(userPrefs);
        this.userPrefs.resetData(userPrefs);
    }

    @Override
    public ReadOnlyUserPrefs getUserPrefs() {
        return userPrefs;
    }

    @Override
    public GuiSettings getGuiSettings() {
        return userPrefs.getGuiSettings();
    }

    @Override
    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        userPrefs.setGuiSettings(guiSettings);
    }

    @Override
    public Path getRecipeBookFilePath() {
        return userPrefs.getRecipeBookFilePath();
    }

    @Override
    public void setRecipeBookFilePath(Path recipeBookFilePath) {
        requireNonNull(recipeBookFilePath);
        userPrefs.setRecipeBookFilePath(recipeBookFilePath);
    }

    // ====== RecipeBook ======

    @Override
    public void setRecipeBook(ReadOnlyRecipeBook recipeBook) {
        this.recipeBook.resetData(recipeBook);
    }

    @Override
    public ReadOnlyRecipeBook getRecipeBook() {
        return recipeBook;
    }

    @Override
    public boolean hasRecipe(Recipe recipe) {
        requireNonNull(recipe);
        return recipeBook.hasRecipe(recipe);
    }

    @Override
    public void deleteRecipe(Recipe toDelete) {
        requireNonNull(toDelete);
        recipeBook.removeRecipe(toDelete);
    }

    @Override
    public void addRecipe(Recipe toAdd) {
        requireNonNull(toAdd);
        recipeBook.addRecipe(toAdd);
        updateFilteredRecipeList(PREDICATE_SHOW_ALL_RECIPES);
    }

    @Override
    public void setRecipe(Recipe toReplace, Recipe editedRecipe) {
        requireAllNonNull(toReplace, editedRecipe);
        recipeBook.setRecipe(toReplace, editedRecipe);
    }

    // ====== Filtered Recipe List Accessors ======

    @Override
    public ObservableList<Recipe> getFilteredRecipeList() {
        return filteredRecipes;
    }

    @Override
    public void updateFilteredRecipeList(Predicate<Recipe> predicate) {
        requireNonNull(predicate);
        filteredRecipes.setPredicate(predicate);
    }

    // ====== Equality ======

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RecipeBookModelManager)) {
            return false;
        }

        if (o == this) {
            return false;
        }

        RecipeBookModelManager other = (RecipeBookModelManager) o;
        return this.recipeBook.equals(other.recipeBook)
                && this.userPrefs.equals(other.userPrefs)
                && this.filteredRecipes.equals(other.filteredRecipes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeBook, userPrefs, filteredRecipes);
    }
}
