package com.yjy.wallet.bean.neo

data class NEOTxInfo(val contract: String = "",
                     val vouts: List<VoutsItem>?,
                     val txid: String = "",
                     val description: Any? = null,
                     val block_hash: String = "",
                     val block_height: Int = 0,
                     val type: String = "",
                     val version: Int = 0,
                     val nonce: Any? = null,
                     val net_fee: Int = 0,
                     val size: Int = 0,
                     val vin: List<VinItem>?,
                     val time: Int = 0,
                     val sys_fee: Int = 0,
                     val scripts: List<ScriptsItem>?,
                     val asset: String = "",
                     val pubkey: String = "",
                     val errors: Any? = null)