package com.example.data.remote.auth

import com.example.domain.model.InvalidCredentialsException
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import io.reactivex.rxjava3.core.Completable
import java.util.concurrent.TimeUnit

class AuthFirebaseImpl : AuthFirebase {
    private val auth = FirebaseAuth.getInstance()

    lateinit var verificationID: String
    lateinit var token: ForceResendingToken
    override fun sendSmsCode(phone: String): Completable = Completable.create {

        val callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                TODO("Not yet implemented")
            }

            override fun onVerificationFailed(e: FirebaseException) {
                it.onError(e)
            }

            override fun onCodeSent(verificationID: String, token: ForceResendingToken) {
                this@AuthFirebaseImpl.verificationID = verificationID
                this@AuthFirebaseImpl.token = token
                it.onComplete()
            }
        }

        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    override fun verify(code: String): Completable = Completable.create {
        val credential = PhoneAuthProvider.getCredential(verificationID, code)
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    it.onComplete()
                } else {
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        it.onError(InvalidCredentialsException())
                    }
                }
            }

    }


}