plugins {
  id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

rootProject.name = "compose-server"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

fun Pair<String, List<String>>.useFile() {
  second.forEach { n ->
    include("$first:$n")
    findProject(":$first:$n")?.name = "$first-$n"
  }
}

listOf(
    "testtoolkit",
    "version-catalog",
    "shared",
    "bom",
    "meta",
    "gradle-plugin",
    "cacheable",
    "cacheable",
    "pay",
  )
  .forEach { p ->
    include(p)
    findProject(":$p")?.name = p
  }

("sms" to listOf("tencent", "shared")).useFile()

("mcp" to listOf("shared", "langchain4j")).useFile()

("oss" to listOf("shared", "minio", "aliyun-oss", "huawei-obs")).useFile()

("rds" to
    listOf(
      "shared",
      "crud",
      "jimmer-ext-postgres",
      "flyway-migration-postgresql",
    ))
  .useFile()

// 数据采集器
("data" to listOf("crawler", "extract")).useFile()

// 安全相关
("security" to listOf("spring", "oauth2", "crypto")).useFile()

// 特定依赖处理
("depend" to
    listOf(
      "servlet",
      "paho",
      "http-exchange",
      "jackson",
      "springdoc-openapi",
      "xxl-job",
    ))
  .useFile()

// ksp
("ksp" to listOf("plugin", "shared")).useFile()
