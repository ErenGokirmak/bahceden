package com.swifties.bahceden.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.swifties.bahceden.data.AuthUser;
import com.swifties.bahceden.databinding.ActivitySecurityProfileBinding;
import com.swifties.bahceden.models.Customer;
import com.swifties.bahceden.models.User;

import java.util.HashMap;
import java.util.Map;

public class SecurityProfileActivity extends AppCompatActivity {
    private ActivitySecurityProfileBinding binding;
    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecurityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Back button initialization
        binding.securityBackButton.setOnClickListener(backView -> SecurityProfileActivity.super.onBackPressed());

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();

        binding.securityChangePasswordButton.setOnClickListener(changePasswordView -> {
            String oldPassword = String.valueOf(binding.securityCurrentPasswordField.getText());
            String newPassword = String.valueOf(binding.securityNewPasswordField.getText());
            String confirmNewPassword = String.valueOf(binding.securityConfirmNewPasswordField.getText());

            // If confirm doesn't match with new password
            if (!newPassword.equals(confirmNewPassword)) {
                binding.securityConfirmNewPasswordField.setError("Confirm password must match with new password");
                return;
            }

            // TODO: the getEmail() returns null and I can't figure out why.
            //  will need further investigation

            // Try to sign in with old password
            firebaseAuth.signInWithEmailAndPassword(AuthUser.getInstance().getUser().getEmail(), oldPassword)
                    .addOnSuccessListener(authResult -> {
                        User user = AuthUser.getInstance().getUser();
                        Map<String, String> updatedUser = new HashMap<>();

                        // Cursed way of determining user type
                        if (AuthUser.getInstance().getUser() instanceof Customer) {
                            updatedUser.put("userType", "1");
                        } else {
                            updatedUser.put("userType", "2");
                        }
                        updatedUser.put("password", newPassword);
                        updatedUser.put("email", user.getEmail()); // FIXME: <- this getEmail() returns null

                        String userId = FirebaseAuth.getInstance().getUid();
                        firebaseFirestore.collection("user")
                                .document(userId)
                                .set(updatedUser);
                    }).addOnFailureListener(authResult -> {
                        Log.e("error", authResult.getMessage());
                    });

        });
    }
}