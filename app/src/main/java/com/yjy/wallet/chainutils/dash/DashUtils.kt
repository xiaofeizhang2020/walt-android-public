package com.yjy.wallet.chainutils.dash

import com.weiyu.baselib.net.exception.BackErrorException
import com.yjy.wallet.Constant.Companion.main
import com.yjy.wallet.chainutils.btc.BTCUtils
import io.neow3j.utils.Numeric
import org.bitcoinj.core.*
import org.bitcoinj.script.ScriptBuilder

/**
 * weiweiyu
 * 2019/8/6
 * 575256725@qq.com
 * 13115284785
 */
class DashUtils {
    companion object {
        fun getAddressHax(address: String): String {
            var s = ScriptBuilder.createOutputScript(Address.fromString(DashMainNetParams.get(), address)).program
            return Numeric.toHexStringNoPrefix(s)
        }

        fun getAddress(pubKeyHash: ByteArray): String {
            return Base58.encodeChecked(if (main) 0x4c else 0x8c, pubKeyHash)
        }

        fun getKey(key: ByteArray): String {
            val bytes = ByteArray(33)//压缩
            System.arraycopy(key, 0, bytes, 0, 32)
            bytes[32] = 1
            return if (main)
                Base58.encodeChecked(0xcc, bytes)
            else {
                Base58.encodeChecked(0xEF, bytes)
            }
        }

        fun getByteKey(key58: String): ByteArray {
            // 1 byte version + data bytes + 4 bytes check code (a truncated hash)
            val byte = Base58.decode(key58)
            //第一位版本号
            if (byte.size == 38) {//去压缩
                val byte32 = ByteArray(32)
                System.arraycopy(byte, 1, byte32, 0, 32)
                return byte32
            }
            return byte
        }

        @Throws(BackErrorException::class)
        fun sign(fromAddress: String, toAddress: String, ecKey: ECKey, amount: Long, fee: Long, utxos: List<UTXO>?, remark: String): Transaction {
            val networkParameters = DashMainNetParams.get()
            return BTCUtils().sign(networkParameters, fromAddress, toAddress, ecKey, amount, fee, utxos, remark)
        }

    }
}