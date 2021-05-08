package org.vepanimas.uml.javascript;

import com.intellij.diagram.actions.DiagramAddElementAction;
import com.intellij.diagram.extras.DiagramExtras;
import com.intellij.diagram.extras.providers.DiagramDnDProvider;
import com.intellij.diagram.settings.DiagramConfigElement;
import com.intellij.diagram.settings.DiagramConfigGroup;
import com.intellij.psi.PsiElement;
import com.intellij.uml.utils.DiagramBundle;
import org.jetbrains.annotations.NotNull;
import org.vepanimas.uml.javascript.actions.JavaScriptAddElementAction;


public final class JavaScriptUmlExtras extends DiagramExtras<PsiElement> {

    private final JavaScriptUmlDnDProvider myUmlDnDProvider = new JavaScriptUmlDnDProvider();
    private final DiagramConfigGroup[] myAdditionalSettings;

    JavaScriptUmlExtras() {
        DiagramConfigGroup dependenciesGroup = new DiagramConfigGroup(DiagramBundle.message("uml.dependencies.settings.group.title"));
        for (JavaScriptUmlDependenciesSettingsOption option : JavaScriptUmlDependenciesSettingsOption.values()) {
            dependenciesGroup.addElement(new DiagramConfigElement(option.getDisplayName(), true));
        }
        myAdditionalSettings = new DiagramConfigGroup[]{dependenciesGroup};
    }

    @Override
    public DiagramDnDProvider<PsiElement> getDnDProvider() {
        return myUmlDnDProvider;
    }

    public DiagramAddElementAction getAddElementHandler() {
        return new JavaScriptAddElementAction();
    }

    @Override
    public DiagramConfigGroup @NotNull [] getAdditionalDiagramSettings() {
        return myAdditionalSettings;
    }

    @Override
    public boolean isExpandCollapseActionsImplemented() {
        return true;
    }
}