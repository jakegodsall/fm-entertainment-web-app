import FloatingLabelFormInput from "./FloatingLabelFormInput";

export default function LoginForm() {
    return (
        <form>
            <h1 className="mb-[4rem] text-[3.2rem] font-light tracking-[-0.05rem]">
                Login
            </h1>
            <div className="flex flex-col gap-[2.4rem]">
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
        </form>
    );
}
