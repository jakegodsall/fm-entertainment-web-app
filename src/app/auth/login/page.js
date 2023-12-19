import Image from "next/image";

import Card from "@/app/components/ui/Card";
import LoginForm from "@/app/components/forms/LoginForm";

import appLogo from "../../../../public/assets/logo.svg";

export default function LoginPage() {
    return (
        <div className="mb-[17rem] flex flex-col items-center gap-[5.8rem] px-[2.4rem] py-[4.8rem]">
            <Image src={appLogo} alt="app logo" />
            <Card>
                <LoginForm />
            </Card>
        </div>
    );
}
