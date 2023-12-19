import Link from "next/link";

import Button from "../ui/Button";
import FloatingLabelFormInput from "./FloatingLabelFormInput";

export default function LoginForm() {
    return (
        <form>
            <h1 className="mb-[4rem] text-[3.2rem] font-extralight tracking-[-0.05rem]">
                Login
            </h1>
            <div className="mb-[5.4rem] flex flex-col gap-[2.4rem]">
                <FloatingLabelFormInput
                    htmlFor="email"
                    label="Email address"
                    type="text"
                />
                <FloatingLabelFormInput
                    htmlFor="password"
                    label="Password"
                    type="password"
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
