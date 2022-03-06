package com.booster.test;

import java.util.function.Consumer;

import com.android.build.gradle.AppExtension;
import com.android.build.gradle.api.ApplicationVariant;
import com.android.build.gradle.api.BaseVariant;
import com.android.build.gradle.internal.variant.BaseVariantData;
//import com.didiglobal.booster.gradle.AGPInterfaceKt;
import com.didiglobal.booster.gradle.AGPInterfaceKt;
import com.didiglobal.booster.gradle.ProjectKt;
import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class TestPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        //此处调用一次则可以正常获取agp
        //project.getLogger().error("getAGP:" + AGPInterfaceKt.getAGP());
        project.afterEvaluate(p -> {
            p.getExtensions().findByType(AppExtension.class).getApplicationVariants().all(
                (Action<BaseVariant>)baseVariant -> {
                    BaseVariantData variantData = AGPInterfaceKt.getAGP().getVariantData(baseVariant);
                    p.getLogger().error("variantData:" + variantData);
                });
        });
    }
}
