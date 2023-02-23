package org.jooq.mcve.test.kotlin.postgres

import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.impl.DSL
import org.jooq.mcve.kotlin.postgres.keys.SEGMENT_CODE_KEY
import org.jooq.mcve.kotlin.postgres.tables.references.SEGMENT
import org.jooq.tools.JooqLogger
import org.junit.After
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test
import java.sql.Connection
import java.sql.DriverManager
import java.util.Properties

class KotlinTest {
    companion object {
        var log: JooqLogger = JooqLogger.getLogger(KotlinTest::class.java)
        var connection: Connection? = null
        var ctx: DSLContext? = null

        @BeforeClass
        @JvmStatic
        fun init() {
            val properties = Properties()
            properties.setProperty("username", "postgres")
            properties.setProperty("password", "postgres")
            log.info("Connecting")
            connection = DriverManager.getConnection(
                    System.getProperty("db.url"),
                    System.getProperty("db.username"),
                    System.getProperty("db.password")
            )
            ctx = DSL.using(connection, SQLDialect.POSTGRES)
            connection!!.createStatement().use { s -> log.info("Finished setup") }
        }
    }

    @Before
    fun setup() {
        ctx().delete(SEGMENT).execute()
    }

    @After
    fun after() {
    }

    fun ctx(): DSLContext = ctx!!

    @Test
    fun mcveTest() {
        // setup
        ctx().insertInto(SEGMENT)
                .columns(SEGMENT.ID, SEGMENT.CODE, SEGMENT.START, SEGMENT.FINISH, SEGMENT.VALUE)
                .values(DSL.defaultValue(SEGMENT.ID), DSL.value("foo"), DSL.value(1), DSL.value(2), DSL.value(10.0f))
                .execute()

        // test
        val data = listOf(
                MySegment("foo", 10, 20, 15.0f),
                MySegment("bar", 30, 50, 2.5f)
        )

        ctx().insertInto(SEGMENT)
                .columns(*SEGMENT.fields())
                .valuesOfRecords(data.map { seg ->
                    ctx().newRecord(SEGMENT).apply {
                        this.start = seg.start
                        this.finish = seg.finish
                        this.value = seg.value
                        this.code = seg.code
                    }
                })
                .onConflictOnConstraint(SEGMENT_CODE_KEY)
                .doUpdate()
                .setAllToExcluded()
                .execute()
    }
}

data class MySegment(val code: String, val start: Int?, val finish: Int?, val value: Float?)
