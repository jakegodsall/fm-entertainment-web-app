"use client";

import React, { useState } from "react";

import Link from "next/link";

import Button from "../ui/Button";
import FloatingLabelFormInput from "./FloatingLabelFormInput";
import { validateEmail, validatePassword } from "@/utils/validators";

export default function LoginForm() {
    const [fieldValues, setFieldValues] = useState({
        email: {
            value: "",
            hasBeenEdited: false,
        },
        password: {
            value: "",
            hasBeenEdited: false,
        },
    });

    function handleOnSubmit(event) {
        event.preventDefault();

        const fd = new FormData(event.target);
        const dataObj = Object.fromEntries(fd.entries());
    }

    function handleOnBlur(identifier, event) {
        if (event.target.value === "") {
            setFieldValues((prevValues) => ({
                ...prevValues,
                [identifier]: {
                    ...prevValues[identifier],
                    hasBeenEdited: false,
                },
            }));
        } else {
            setFieldValues((prevValues) => ({
                ...prevValues,
                [identifier]: {
                    ...prevValues[identifier],
                    hasBeenEdited: true,
                },
            }));
        }
    }

    function handleOnChange(identifier, event) {
        setFieldValues((prevValues) => ({
            ...prevValues,
            [identifier]: {
                ...prevValues[identifier],
                value: event.target.value,
            },
        }));
    }

    const emailIsInvalid =
        fieldValues.email.hasBeenEdited &&
        !validateEmail(fieldValues.email.value);

    const passwordIsInvalid =
        fieldValues.password.hasBeenEdited &&
        !validatePassword(fieldValues.password.value);

    return (
        <form onSubmit={handleOnSubmit}>
            <h1 className="mb-[4rem] text-[3.2rem] font-extralight tracking-[-0.05rem]">
                Login
            </h1>
            <div className="mb-[5.4rem] flex flex-col gap-[2.4rem]">
                <FloatingLabelFormInput
                    htmlFor="email"
                    label="Email address"
                    type="text"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.email.value}
                    errorFlag={emailIsInvalid}
                    errorMessage="Email is invalid"
                />
                <FloatingLabelFormInput
                    htmlFor="password"
                    label="Password"
                    type="password"
                    onBlur={handleOnBlur}
                    onChange={handleOnChange}
                    value={fieldValues.password.value}
                    errorFlag={passwordIsInvalid}
                    errorMessage="Password is invalid"
                />
            </div>
            <Button>Login to your account</Button>
            <p className="mt-[2.4rem] text-center text-[1.5rem] font-extralight">
                Don't have an account?{" "}
                <Link className="text-primary-red" href="/auth/signup">
                    Sign Up
                </Link>
            </p>
        </form>
    );
}
