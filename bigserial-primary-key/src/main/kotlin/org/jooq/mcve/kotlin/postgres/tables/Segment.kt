/*
 * This file is generated by jOOQ.
 */
package org.jooq.mcve.kotlin.postgres.tables


import java.util.function.Function

import kotlin.collections.List

import org.jooq.Field
import org.jooq.ForeignKey
import org.jooq.Identity
import org.jooq.Name
import org.jooq.Record
import org.jooq.Records
import org.jooq.Row5
import org.jooq.Schema
import org.jooq.SelectField
import org.jooq.Table
import org.jooq.TableField
import org.jooq.TableOptions
import org.jooq.UniqueKey
import org.jooq.impl.DSL
import org.jooq.impl.Internal
import org.jooq.impl.SQLDataType
import org.jooq.impl.TableImpl
import org.jooq.mcve.kotlin.postgres.Mcve
import org.jooq.mcve.kotlin.postgres.keys.SEGMENT_CODE_KEY
import org.jooq.mcve.kotlin.postgres.keys.SEGMENT_PKEY
import org.jooq.mcve.kotlin.postgres.tables.records.SegmentRecord


/**
 * This class is generated by jOOQ.
 */
@Suppress("UNCHECKED_CAST")
open class Segment(
    alias: Name,
    child: Table<out Record>?,
    path: ForeignKey<out Record, SegmentRecord>?,
    aliased: Table<SegmentRecord>?,
    parameters: Array<Field<*>?>?
): TableImpl<SegmentRecord>(
    alias,
    Mcve.MCVE,
    child,
    path,
    aliased,
    parameters,
    DSL.comment(""),
    TableOptions.table()
) {
    companion object {

        /**
         * The reference instance of <code>mcve.segment</code>
         */
        val SEGMENT: Segment = Segment()
    }

    /**
     * The class holding records for this type
     */
    override fun getRecordType(): Class<SegmentRecord> = SegmentRecord::class.java

    /**
     * The column <code>mcve.segment.id</code>.
     */
    val ID: TableField<SegmentRecord, Long?> = createField(DSL.name("id"), SQLDataType.BIGINT.nullable(false).identity(true), this, "")

    /**
     * The column <code>mcve.segment.start</code>.
     */
    val START: TableField<SegmentRecord, Int?> = createField(DSL.name("start"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>mcve.segment.finish</code>.
     */
    val FINISH: TableField<SegmentRecord, Int?> = createField(DSL.name("finish"), SQLDataType.INTEGER.nullable(false), this, "")

    /**
     * The column <code>mcve.segment.value</code>.
     */
    val VALUE: TableField<SegmentRecord, Float?> = createField(DSL.name("value"), SQLDataType.REAL.nullable(false), this, "")

    /**
     * The column <code>mcve.segment.code</code>.
     */
    val CODE: TableField<SegmentRecord, String?> = createField(DSL.name("code"), SQLDataType.VARCHAR(128).nullable(false), this, "")

    private constructor(alias: Name, aliased: Table<SegmentRecord>?): this(alias, null, null, aliased, null)
    private constructor(alias: Name, aliased: Table<SegmentRecord>?, parameters: Array<Field<*>?>?): this(alias, null, null, aliased, parameters)

    /**
     * Create an aliased <code>mcve.segment</code> table reference
     */
    constructor(alias: String): this(DSL.name(alias))

    /**
     * Create an aliased <code>mcve.segment</code> table reference
     */
    constructor(alias: Name): this(alias, null)

    /**
     * Create a <code>mcve.segment</code> table reference
     */
    constructor(): this(DSL.name("segment"), null)

    constructor(child: Table<out Record>, key: ForeignKey<out Record, SegmentRecord>): this(Internal.createPathAlias(child, key), child, key, SEGMENT, null)
    override fun getSchema(): Schema? = if (aliased()) null else Mcve.MCVE
    override fun getIdentity(): Identity<SegmentRecord, Long?> = super.getIdentity() as Identity<SegmentRecord, Long?>
    override fun getPrimaryKey(): UniqueKey<SegmentRecord> = SEGMENT_PKEY
    override fun getUniqueKeys(): List<UniqueKey<SegmentRecord>> = listOf(SEGMENT_CODE_KEY)
    override fun `as`(alias: String): Segment = Segment(DSL.name(alias), this)
    override fun `as`(alias: Name): Segment = Segment(alias, this)
    override fun `as`(alias: Table<*>): Segment = Segment(alias.getQualifiedName(), this)

    /**
     * Rename this table
     */
    override fun rename(name: String): Segment = Segment(DSL.name(name), null)

    /**
     * Rename this table
     */
    override fun rename(name: Name): Segment = Segment(name, null)

    /**
     * Rename this table
     */
    override fun rename(name: Table<*>): Segment = Segment(name.getQualifiedName(), null)

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------
    override fun fieldsRow(): Row5<Long?, Int?, Int?, Float?, String?> = super.fieldsRow() as Row5<Long?, Int?, Int?, Float?, String?>

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    fun <U> mapping(from: (Long?, Int?, Int?, Float?, String?) -> U): SelectField<U> = convertFrom(Records.mapping(from))

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    fun <U> mapping(toType: Class<U>, from: (Long?, Int?, Int?, Float?, String?) -> U): SelectField<U> = convertFrom(toType, Records.mapping(from))
}
