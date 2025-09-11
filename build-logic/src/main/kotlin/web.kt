import java.io.File
import java.net.URI
import java.nio.file.Files
import java.nio.file.StandardCopyOption

fun downloadFileFromUrl(stringUrl: String, target: File): Boolean {
    if(target.exists()) return false

    val url = URI.create(stringUrl).toURL()

    Files.copy(url.openStream(), target.toPath(), StandardCopyOption.REPLACE_EXISTING)

    return true
}
