export default function Button({ children }) {
    return (
        <button className="w-full rounded-[0.6rem] bg-primary-red p-[1.4rem] text-[1.5rem] font-extralight">
            {children}
        </button>
    );
}
