import com.android.build.api.dsl.ApplicationExtension
import com.zhixue.lite.configureKotlinAndroid
import com.zhixue.lite.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.application.get().pluginId)
                apply(libs.plugins.kotlin.android.get().pluginId)
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig.targetSdk = 34
                configureKotlinAndroid(this)
            }
        }
    }
}