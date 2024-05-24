import com.android.build.api.dsl.LibraryExtension
import com.zhixue.lite.configureKotlinAndroid
import com.zhixue.lite.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply(libs.plugins.android.library.get().pluginId)
                apply(libs.plugins.kotlin.android.get().pluginId)
            }

            extensions.configure<LibraryExtension> {
                lint.targetSdk = 34
                configureKotlinAndroid(this)
            }
        }
    }
}