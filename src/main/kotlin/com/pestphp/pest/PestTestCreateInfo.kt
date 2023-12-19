package com.pestphp.pest

import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFile
import com.intellij.psi.codeStyle.CodeStyleManager
import com.jetbrains.php.lang.psi.PhpPsiElementFactory
import com.jetbrains.php.templates.PhpFileTemplateUtil.INTERNAL_PHP_FILE_TEMPLATE_NAME
import com.jetbrains.php.testFramework.PhpUnitAbstractTestCreateInfo
import javax.swing.Icon

object PestTestCreateInfo : PhpUnitAbstractTestCreateInfo() {
    override fun getName(): String {
        return "Pest"
    }

    override fun getTemplateName(): String {
        return INTERNAL_PHP_FILE_TEMPLATE_NAME
    }

    override fun getIcon(): Icon {
        return PestIcons.Logo
    }

    override fun getTestMethodText(project: Project, classFqn: String, methodName: String): String {
        return "test('$methodName', function(){})"
    }

    override fun shouldPostprocessTemplateFile(): Boolean {
        return true
    }

    override fun postprocessTemplateFile(file: PsiFile) {
        val project = file.project
        val statement = PhpPsiElementFactory.createStatement(project, getTestMethodText(project, "", "") + ";")
        file.add(statement)
        CodeStyleManager.getInstance(project).reformat(file)
    }
}