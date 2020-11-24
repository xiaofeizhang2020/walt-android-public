package com.yjy.wallet.bean.eth

data class TokenItem(val blockHash: String = "",
                     val tokenSymbol: String = "",
                     val tokenName: String = "",
                     val contractAddress: String = "",
                     val transactionIndex: String = "",
                     val confirmations: String = "0",
                     val nonce: String = "",
                     val timeStamp: String = "",
                     val input: String = "",
                     val gasUsed: String = "",
                     val blockNumber: String = "",
                     val gas: String = "",
                     val tokenDecimal: String = "",
                     val cumulativeGasUsed: String = "",
                     val from: String = "",
                     val to: String = "",
                     val value: String = "",
                     val hash: String = "",
                     val gasPrice: String = "")