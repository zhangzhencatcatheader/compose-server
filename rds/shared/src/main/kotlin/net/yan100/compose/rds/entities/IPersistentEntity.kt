package net.yan100.compose.rds.entities

import net.yan100.compose.RefId
import net.yan100.compose.rds.converters.JimmerLongToStringConverter
import net.yan100.compose.rds.generators.JimmerSnowflakeLongIdGenerator
import org.babyfish.jimmer.jackson.JsonConverter
import org.babyfish.jimmer.sql.GeneratedValue
import org.babyfish.jimmer.sql.Id
import org.babyfish.jimmer.sql.MappedSuperclass

@MappedSuperclass
interface IPersistentEntity {
  /** 数据库主键 */
  @Id
  @JsonConverter(JimmerLongToStringConverter::class)
  @GeneratedValue(
    generatorRef = JimmerSnowflakeLongIdGenerator.Companion.JIMMER_SNOWFLAKE_LONG_ID_GENERATOR_NAME
  )
  val id: RefId
}
